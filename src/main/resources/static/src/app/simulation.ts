import { SimulationResultDto } from './simulation-result-dto';

export class Simulation {
    [x: string]: any;
    id?: number;
    name!: string;
    populationSize!: number;
    initialInfected!: number;
    reproductionNumber!: number;
    mortalityRate!: number;
    daysRecovery!: number;
    daysToDeath!: number;
    simulationDays!: number;
    susceptible?: number;
    infected?: number;
    dead?: number;
    recovered?: number;
    incidenceRate?: number;
    simulationResultDtoList?: SimulationResultDto[];
  }
  