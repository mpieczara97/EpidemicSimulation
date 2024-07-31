import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SimulationService } from '../simulation.service';
import { Simulation } from '../simulation';

@Component({
  selector: 'app-simulation-form',
  templateUrl: './simulation-form.component.html',
  styleUrls: ['./simulation-form.component.css'],
})
export class SimulationFormComponent {
  simulation: Simulation = new Simulation();

  constructor(private simulationService: SimulationService, private router: Router) {}

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
