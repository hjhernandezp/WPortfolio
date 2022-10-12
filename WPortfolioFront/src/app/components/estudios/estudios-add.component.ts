import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudios } from 'src/app/models/estudios';
import { EstudiosService } from 'src/app/services/estudios.service';

@Component({
  selector: 'app-estudios-add',
  templateUrl: './estudios-add.component.html',
  styleUrls: ['./estudios-add.component.css']
})
export class EstudiosAddComponent implements OnInit {
  estCarrera: string;
  estMencion: string;
  estEstado: string;
  estInstituto: string;
  estLugar: string;

  constructor(
    private serEstudios: EstudiosService, 
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const estudios = new Estudios(
      this.estCarrera, 
      this.estMencion,
      this.estEstado,
      this.estInstituto,
      this.estLugar
    );

    this.serEstudios.save(estudios).subscribe(
      data => {
        alert("Registro añadido correctamente en: Estudios")
        this.router.navigate([''])
      }, err=> {
        alert("Error de sistema al añadir: Estudios")
        this.router.navigate([''])
      }
    );
  }
}
