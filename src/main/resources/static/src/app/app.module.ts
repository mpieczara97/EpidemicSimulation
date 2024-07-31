import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { AppRoutingModule, routes } from './app.routes'; 
import { SimulationListComponent } from "./simulation-list/simulation-list.component";
import { SimulationDetailComponent } from "./simulation-detail/simulation-detail.component";
import { SimulationFormComponent } from "./simulation-form/simulation-form.component";
import { SimulationEditComponent } from "./simulation-edit/simulation-edit.component";
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    SimulationListComponent, 
    SimulationDetailComponent, 
    SimulationFormComponent, 
    SimulationEditComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgxChartsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }