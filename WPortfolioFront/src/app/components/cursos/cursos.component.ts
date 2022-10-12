import { Component, OnInit } from '@angular/core';
import { Cursos } from 'src/app/models/cursos';
import { CursosService } from 'src/app/services/cursos.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {
  cursos: Cursos[] = [];

  constructor(
    private serCursos: CursosService, 
    private serToken: TokenService
  ) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadCursos();
    if(this.serToken.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadCursos(): void {
    this.serCursos.lista().subscribe(
      data => {
        this.cursos = data
      }
    );
  }

  deleteCursos(id?: number) {
    if(id != undefined) {
      this.serCursos.delete(id).subscribe(
        data => {
          this.loadCursos()
        }, err => {
          alert("Error de sistema al borrar: Cursos")
        }
      );
    }
  }
}
