import { Consommation } from "./consommation"
import { Voiture } from "./voiture"

export interface Mission {
    id: number
    statusMission: string
    dateDebut: number
    dateFin: number
    locationDebut: string
    locationFin: string
    compagnons: string[]
    conducteur: string
    voiture: Voiture
    consommation: Consommation
    duree: string
  }