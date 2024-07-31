import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Simulation } from './simulation';

@Injectable({
  providedIn: 'root'
})
export class SimulationService {
  private baseUrl = 'http://localhost:8080/simulation'; 

  constructor(private http: HttpClient) { }

  getSimulations(): Observable<Simulation[]> {
    return this.http.get<Simulation[]>(`${this.baseUrl}`);
  }

  getSimulation(id: number): Observable<Simulation> {
    return this.http.get<Simulation>(`${this.baseUrl}/${id}`);
  }

  createSimulation(simulation: Simulation): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, simulation);
  }

  updateSimulation(id: number, simulation: Simulation): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, simulation);
  }

  deleteSimulation(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
