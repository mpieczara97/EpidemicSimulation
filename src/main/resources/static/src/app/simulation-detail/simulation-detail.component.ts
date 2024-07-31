import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SimulationService } from '../simulation.service';
import { Simulation } from '../simulation';
import { SimulationResultDto } from '../simulation-result-dto';

@Component({
  selector: 'app-simulation-detail',
  templateUrl: './simulation-detail.component.html',
  styleUrls: ['./simulation-detail.component.css'],
})
export class SimulationDetailComponent implements OnInit {
  simulation: Simulation | undefined;
  chartData: any[] = [];

  view: [number, number] = [700, 400];
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  gradient: boolean = false;
  showLegend: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Day';
  showYAxisLabel: boolean = true;
  yAxisLabel: string = 'Population Size';
  colorScheme: any = {
    domain: ['#FF5733', '#C70039', '#900C3F', '#581845']
  };

  constructor(
    private route: ActivatedRoute,
    private simulationService: SimulationService
  ) {}

  ngOnInit(): void {
    this.getSimulationDetails();
  }

  getSimulationDetails(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.simulationService.getSimulation(+id).subscribe(
        (simulation) => {
          this.simulation = simulation;
          if (simulation.simulationResultDtoList) {
            this.prepareChartData(simulation.simulationResultDtoList);
          }
          console.log('Simulation details:', simulation);
        },
        (error) => {
          console.error('Error fetching simulation details:', error);
        }
      );
    }
  }

  prepareChartData(results: SimulationResultDto[]): void {
    const susceptibleData: { name: number, value: number }[] = [];
    const infectedData: { name: number, value: number }[] = [];
    const deadData: { name: number, value: number }[] = [];
    const recoveredData: { name: number, value: number }[] = [];

    results.forEach(result => {
      susceptibleData.push({ name: result.day, value: result.susceptible });
      infectedData.push({ name: result.day, value: result.infected });
      deadData.push({ name: result.day, value: result.dead });
      recoveredData.push({ name: result.day, value: result.recovered });
    });

    this.chartData = [
      {
        name: 'Susceptible',
        series: susceptibleData
      },
      {
        name: 'Infected',
        series: infectedData
      },
      {
        name: 'Dead',
        series: deadData
      },
      {
        name: 'Recovered',
        series: recoveredData
      }
    ];
  }
}
