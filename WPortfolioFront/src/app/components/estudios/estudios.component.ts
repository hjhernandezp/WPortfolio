import { Component, OnInit } from '@angular/core';
import { Estudios } from 'src/app/models/estudios';
import { EstudiosService } from 'src/app/services/estudios.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-estudios',
  templateUrl: './estudios.component.html',
  styleUrls: ['./estudios.component.css']
})
export class EstudiosComponent implements OnInit {
  estudios: Estudios[] = [];

  constructor(
    private serEstudios: EstudiosService, 
    private serToken: TokenService
  ) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadEstudios();
    if(this.serToken.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadEstudios(): void {
    this.serEstudios.lista().subscribe(
      data => {
        this.estudios = data
      }
    );
  }

  deleteEstudios(id?: number) {
    if(id != undefined) {
      this.serEstudios.delete(id).subscribe(
        data => {
          this.loadEstudios()
        }, err => {
          alert("Error de sistema al borrar: Estudios")
        }
      );
    }
  }
}
