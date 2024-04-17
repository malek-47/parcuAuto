import { Maintenance } from "./maintenance"
import { Report } from "./report"

export interface Voiture {
    id: number
    marque: string
    model:string
    numMatricule: string
    portName: string
    statusVoiture: string
    maintenanceList: Maintenance[]
    accidentList: Report[]
    numChassis: string
    carburant: string
    compteurKm: bigint
    prochainVidange: bigint
    countAccident: number
    assurance:string
    visiteTechnique: string
    carteGrise: string
    vignette: string
  }