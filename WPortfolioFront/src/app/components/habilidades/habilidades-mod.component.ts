import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Habilidades } from 'src/app/models/habilidades';
import { HabilidadesService } from 'src/app/services/habilidades.service';

@Component({
  selector: 'app-habilidades-mod',
  templateUrl: './habilidades-mod.component.html',
  styleUrls: ['./habilidades-mod.component.css']
})
export class HabilidadesModComponent implements OnInit {
  habilidades: Habilidades = null;

  constructor(
    private serHabilidades: HabilidadesService, 
    private activatedRoute: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serHabilidades.detail(id).subscribe(
      data => {
        this.habilidades = data
      }, err => {
        alert("Error de sistema")
        this.router.navigate([''])
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serHabilidades.update(id, this.habilidades).subscribe(
      data => {
        this.router.navigate([''])
      }, err => {
        alert("Error de sistema al editar: Habilidades")
        this.router.navigate([''])
      }
    );
  }
}
