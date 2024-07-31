import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../simulation.service';
import { Simulation } from '../simulation';

@Component({
  selector: 'app-simulation-list',
  templateUrl: './simulation-list.component.html',
  styleUrl: './simulation-list.component.css'
})
export class SimulationListComponent implements OnInit {
  
  simulations: Simulation[] = [];

  constructor(private simulationService: SimulationService) { }

  ngOnInit(): void {
    this.getSimulations();
  }

  private getSimulations() {
    this.simulationService.getSimulations().subscribe(data => {
      this.simulations = data;
    });
  }

  deleteSimulation(id: number | undefined): void {
    if (id !== undefined) {
      this.simulationService.deleteSimulation(id).subscribe(() => {
        this.getSimulations();
      });
    } else {
      console.error('ID is undefined');
    }
  }
}
