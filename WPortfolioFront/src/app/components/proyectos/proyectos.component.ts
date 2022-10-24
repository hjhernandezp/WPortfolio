import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Proyectos } from 'src/app/models/proyectos';
import { ProyectosService } from 'src/app/services/proyectos.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  
  //ARREGLO Y OBJETO
  arreglo: Proyectos[] = [];
  objeto: Proyectos = null;
  
  //DATOS
  nombre: string;
  descripcion: string;
  enlace: string;
  imagen: string;

  //HABILITANTE
  isLogged = false;

  constructor(
    private ComService: ProyectosService, 
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
    this.descripcion = null;
    this.enlace = null;
    this.imagen = null;
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
    const proyectos = new Proyectos(
      this.nombre, 
      this.descripcion,
      this.enlace,
      this.imagen
    );
    this.ComService.save(proyectos).subscribe(
      data => {
        this.onLoad()
        this.onReset()
        alert("Registro añadido correctamente en: Proyectos")
      }, err=> {
        alert("Error de sistema al añadir: Proyectos")
      }
    );
  }

  onUpdate(id: number): void {
    this.ComService.update(id, this.objeto).subscribe(
      data => {
        this.onLoad()
        alert("Registro actualizado en: Proyectos")
      }, err => {
        alert("Error de sistema al editar: Proyectos")
      }
    );
  }

  onDelete(id: number) {
    if(id != undefined) {
      this.ComService.delete(id).subscribe(
        data => {
          this.onLoad()
          alert("Registro eliminado en: Proyectos")
        }, err => {
          alert("Error de sistema al borrar: Proyectos")
        }
      );
    }
  }

  openModal(referencia: any) {
    this.ModalService.open(referencia)
  }
}
