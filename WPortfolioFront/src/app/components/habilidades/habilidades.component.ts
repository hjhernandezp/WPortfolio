import { Component, OnInit } from '@angular/core';
import { Habilidades } from 'src/app/models/habilidades';
import { HabilidadesService } from 'src/app/services/habilidades.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {
  habilidades: Habilidades[] = [];

  constructor(
    private serHabilidades: HabilidadesService, 
    private serToken: TokenService
  ) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadHabilidades();
    if(this.serToken.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadHabilidades(): void {
    this.serHabilidades.lista().subscribe(
      data => {
        this.habilidades = data
      }
    );
  }

  deleteHabilidades(id: number) {
    if(id != undefined) {
      this.serHabilidades.delete(id).subscribe(
        data => {
          this.loadHabilidades()
        }, err => {
          alert("Error de sistema al borrar: Habilidades")
        }
      );
    }
  }
}
