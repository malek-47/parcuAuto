import { Voiture } from "./voiture"

export interface Maintenance {
    id: number
    type: string
    duree: string
    dateMaintenance: string
    frais: string
    voiture: Voiture
  }