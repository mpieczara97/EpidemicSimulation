import { RouterModule, Routes } from '@angular/router';
import { SimulationListComponent } from './simulation-list/simulation-list.component';
import { SimulationDetailComponent } from './simulation-detail/simulation-detail.component';
import { SimulationEditComponent } from './simulation-edit/simulation-edit.component';
import { SimulationFormComponent } from './simulation-form/simulation-form.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
  { path: '', redirectTo: 'simulation-list', pathMatch: 'full' },
  { path: 'simulation-list', component: SimulationListComponent },
  { path: 'simulation-detail/:id', component: SimulationDetailComponent },
  { path: 'simulation-edit', component: SimulationEditComponent },
  { path: 'simulation-edit/:id', component: SimulationEditComponent },
  { path: 'simulation-create', component: SimulationFormComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}