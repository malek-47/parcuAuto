import { Client } from "./client"
import { Voiture } from "./voiture"

export interface Report {
    id: number
    sujet: string
    description: string
    dateAccident: string
    lieuxAccident: string
    voiture: Voiture
    employe: Client
  }