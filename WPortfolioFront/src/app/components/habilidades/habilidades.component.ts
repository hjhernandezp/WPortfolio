import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Habilidades } from 'src/app/models/habilidades';
import { HabilidadesService } from 'src/app/services/habilidades.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {
  
  //ARREGLO Y OBJETO
  arreglo: Habilidades[] = [];
  objeto: Habilidades = null;

  //DATOS
  nombre: string;
  nivel: number;

  //HABILITANTE
  isLogged = false;

  constructor(
    private ComService: HabilidadesService, 
    private SerToken: TokenService,
    private ModalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.onLoad();
    if(this.SerToken.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  onLoad(): void {
    this.ComService.lista().subscribe(
      data => {
        this.arreglo = data
      }
    );
  }

  onReset(): void {
    this.nombre = null;
    this.nivel = null;
  }

  onLocate(id: number, referencia: any) {
    this.ComService.detail(id).subscribe(
      data => {
        this.objeto = data
      }, err => {
        alert("Error de sistema")
      }
    )
    this.ModalService.open(referencia)
  }
  
  onCreate(): void {
    const habilidades = new Habilidades(
      this.nombre, 
      this.nivel
    );
    this.ComService.save(habilidades).subscribe(
      data => {
        this.onLoad()
        this.onReset()
        alert("Registro añadido correctamente en: Habilidades")
      }, err=> {
        alert("Error de sistema al añadir: Habilidades")
      }
    );
  }

  onUpdate(id: number): void {
    this.ComService.update(id, this.objeto).subscribe(
      data => {
        this.onLoad()
        alert("Registro actualizado en: Habilidades")
      }, err => {
        alert("Error de sistema al editar: Habilidades")
      }
    );
  }

  onDelete(id: number) {
    if(id != undefined) {
      this.ComService.delete(id).subscribe(
        data => {
          this.onLoad()
          alert("Registro eliminado en: Habilidades")
        }, err => {
          alert("Error de sistema al borrar: Habilidades")
        }
      );
    }
  }

  openModal(referencia: any) {
    this.ModalService.open(referencia)
  }
}
