import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/models/experiencia';
import { ExperienciaService } from 'src/app/services/experiencia.service';

@Component({
  selector: 'app-experiencia-mod',
  templateUrl: './experiencia-mod.component.html',
  styleUrls: ['./experiencia-mod.component.css']
})
export class ExperienciaModComponent implements OnInit {
  experiencia: Experiencia = null;

  constructor(
    private serExperiencia: ExperienciaService, 
    private activatedRoute: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serExperiencia.detail(id).subscribe(
      data => {
        this.experiencia = data
      }, err => {
        alert("Error de sistema")
        this.router.navigate([''])
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serExperiencia.update(id, this.experiencia).subscribe(
      data => {
        this.router.navigate([''])
      }, err => {
        alert("Error de sistema al editar: Experiencia")
        this.router.navigate([''])
      }
    );
  }
}
