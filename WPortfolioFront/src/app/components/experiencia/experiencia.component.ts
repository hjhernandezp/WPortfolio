import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Experiencia } from 'src/app/models/experiencia';
import { ExperienciaService } from 'src/app/services/experiencia.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  
  //ARREGLO Y OBJETO
  arreglo: Experiencia[] = [];
  objeto: Experiencia = null;
  
  //DATOS
  empresa: string;
  lugar: string;
  cargo: string;

  //HABILITANTE
  isLogged = false;

  constructor(
    private ComService: ExperienciaService, 
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
    this.empresa = null;
    this.lugar = null;
    this.cargo = null;
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
    const experiencia = new Experiencia(
      this.empresa, 
      this.lugar,
      this.cargo
    );
    this.ComService.save(experiencia).subscribe(
      data => {
        this.onLoad()
        this.onReset()
        alert("Registro añadido correctamente en: Experiencia")
      }, err=> {
        alert("Error de sistema al añadir: Experiencia")
      }
    );
  }

  onUpdate(id: number): void {
    this.ComService.update(id, this.objeto).subscribe(
      data => {
        this.onLoad()
        alert("Registro actualizado en: Experiencia")
      }, err => {
        alert("Error de sistema al editar: Experiencia")
      }
    );
  }

  onDelete(id: number) {
    if(id != undefined) {
      this.ComService.delete(id).subscribe(
        data => {
          this.onLoad()
          alert("Registro eliminado en: Experiencia")
        }, err => {
          alert("Error de sistema al borrar: Experiencia")
        }
      );
    }
  }

  openModal(referencia: any) {
    this.ModalService.open(referencia)
  }
}
