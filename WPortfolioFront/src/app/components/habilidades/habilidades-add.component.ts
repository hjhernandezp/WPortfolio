import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Habilidades } from 'src/app/models/habilidades';
import { HabilidadesService } from 'src/app/services/habilidades.service';

@Component({
  selector: 'app-habilidades-add',
  templateUrl: './habilidades-add.component.html',
  styleUrls: ['./habilidades-add.component.css']
})
export class HabilidadesAddComponent implements OnInit {
  habNombre: string;
  habNivel: number;

  constructor(
    private serHabilidades: HabilidadesService, 
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const habilidades = new Habilidades(
      this.habNombre, 
      this.habNivel
    );

    this.serHabilidades.save(habilidades).subscribe(
      data => {
        alert("Registro añadido correctamente en: Habilidades")
        this.router.navigate([''])
      }, err=> {
        alert("Error de sistema al añadir: Habilidades")
        this.router.navigate([''])
      }
    );
  }
}
