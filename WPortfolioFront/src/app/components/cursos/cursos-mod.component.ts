import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cursos } from 'src/app/models/cursos';
import { CursosService } from 'src/app/services/cursos.service';

@Component({
  selector: 'app-cursos-mod',
  templateUrl: './cursos-mod.component.html',
  styleUrls: ['./cursos-mod.component.css']
})
export class CursosModComponent implements OnInit {
  cursos: Cursos = null;

  constructor(
    private serCursos: CursosService, 
    private activatedRoute: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serCursos.detail(id).subscribe(
      data => {
        this.cursos = data
      }, err => {
        alert("Error de sistema")
        this.router.navigate([''])
      }
    );
  }
  
  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serCursos.update(id, this.cursos).subscribe(
      data => {
        this.router.navigate([''])
      }, err => {
        alert("Error de sistema al editar: Cursos")
        this.router.navigate([''])
      }
    );
  }
}
