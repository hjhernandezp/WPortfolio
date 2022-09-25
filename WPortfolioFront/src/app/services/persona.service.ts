import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../models/persona.module';

@Injectable({
  providedIn: 'root'
})

export class PersonaService {

  url = 'http://localhost:8080/personas/'
  constructor(private http: HttpClient) {}

  public getPersona(): Observable<Persona> {
    return this.http.get<Persona>(this.url+'traer');
  }
}
