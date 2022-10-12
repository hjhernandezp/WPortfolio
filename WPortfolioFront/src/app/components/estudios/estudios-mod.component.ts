import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Estudios } from 'src/app/models/estudios';
import { EstudiosService } from 'src/app/services/estudios.service';

@Component({
  selector: 'app-estudios-mod',
  templateUrl: './estudios-mod.component.html',
  styleUrls: ['./estudios-mod.component.css']
})
export class EstudiosModComponent implements OnInit {
  estudios: Estudios = null;

  constructor(
    private serEstudios: EstudiosService, 
    private activatedRoute: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serEstudios.detail(id).subscribe(
      data => {
        this.estudios = data
      }, err => {
        alert("Error de sistema");
        this.router.navigate([''])
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serEstudios.update(id, this.estudios).subscribe(
      data => {
        this.router.navigate([''])
      }, err => {
        alert("Error de sistema al editar: Experiencia");
        this.router.navigate([''])
      }
    );
  }
}
