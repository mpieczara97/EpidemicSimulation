import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SimulationService } from '../simulation.service';
import { Simulation } from '../simulation';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-simulation-edit',
  templateUrl: './simulation-edit.component.html',
  styleUrls: ['./simulation-edit.component.css'],
})
export class SimulationEditComponent {
  simulation: Simulation = new Simulation();

  constructor(
    private simulationService: SimulationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getSimulation();
  }

  getSimulation(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.simulationService.getSimulation(+id).subscribe(simulation => this.simulation = simulation);
    }
  }

  save(): void {
    if (this.simulation.id) {
      this.simulationService.updateSimulation(this.simulation.id, this.simulation).subscribe(() => this.goBack());
    } else {
      this.simulationService.createSimulation(this.simulation).subscribe(() => this.goBack());
    }
  }

  goBack(): void {
    this.router.navigate(['/simulation-list']);
  }
}
