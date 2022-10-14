import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/models/experiencia';
import { ExperienciaService } from 'src/app/services/experiencia.service';

@Component({
  selector: 'app-experiencia-add',
  templateUrl: './experiencia-add.component.html',
  styleUrls: ['./experiencia-add.component.css']
})
export class ExperienciaAddComponent implements OnInit {
  expEmpresa: string;
  expLugar: string;
  expCargo: string;
  
  constructor(
    private serExperiencia: ExperienciaService, 
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const experiencia = new Experiencia(
      this.expEmpresa, 
      this.expLugar, 
      this.expCargo
    );

    this.serExperiencia.save(experiencia).subscribe(
      data => {
        alert("Registro añadido correctamente en: Experiencia")
        this.router.navigate([''])
      }, err=> {
        alert("Error de sistema al añadir: Experiencia")
        this.router.navigate([''])
      }
    );
  }
}
