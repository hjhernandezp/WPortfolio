import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cursos } from 'src/app/models/cursos';
import { CursosService } from 'src/app/services/cursos.service';

@Component({
  selector: 'app-cursos-add',
  templateUrl: './cursos-add.component.html',
  styleUrls: ['./cursos-add.component.css']
})
export class CursosAddComponent implements OnInit {
  curNombre: string;
  curInstituto: string;
  curLugar: string;
  curHoras: number;

  constructor(
    private serCursos: CursosService, 
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const cursos = new Cursos(
      this.curNombre, 
      this.curInstituto,
      this.curLugar,
      this.curHoras
    );

    this.serCursos.save(cursos).subscribe(
      data => {
        alert("Registro añadido correctamente en: Cursos")
        this.router.navigate([''])
      }, err=> {
        alert("Error de sistema al añadir: Cursos")
        this.router.navigate([''])
      }
    );
  }
}
