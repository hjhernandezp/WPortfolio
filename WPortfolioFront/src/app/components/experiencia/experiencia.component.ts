import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/models/experiencia';
import { ExperienciaService } from 'src/app/services/experiencia.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  experiencia: Experiencia[] = [];

  constructor(
    private serExperiencia: ExperienciaService, 
    private serToken: TokenService
  ) { }

  isLogged = false;
  
  ngOnInit(): void {
    this.loadExperiencia();
    if(this.serToken.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadExperiencia(): void {
    this.serExperiencia.lista().subscribe(
      data => {
        this.experiencia = data
      }
    );
  }

  deleteExperiencia(id?: number) {
    if(id != undefined) {
      this.serExperiencia.delete(id).subscribe(
        data => {
          this.loadExperiencia()
        }, err => {
          alert("Error de sistema al borrar: Experiencia")
        }
      );
    }
  }
}
