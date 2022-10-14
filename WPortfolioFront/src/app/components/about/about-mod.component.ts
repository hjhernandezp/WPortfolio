import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/models/persona';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-about-mod',
  templateUrl: './about-mod.component.html',
  styleUrls: ['./about-mod.component.css']
})
export class AboutModComponent implements OnInit {
  persona: Persona = null;

  constructor(
    private serPersona: PersonaService, 
    private activatedRoute: ActivatedRoute, 
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serPersona.detail(id).subscribe(
      data => {
        this.persona = data
      }, err => {
        alert("Error de sistema")
        this.router.navigate([''])
      }
    );
  }
  
  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.serPersona.update(id, this.persona).subscribe(
      data => {
        this.router.navigate([''])
      }, err => {
        alert("Error de sistema al editar: Persona")
        this.router.navigate([''])
      }
    );
  }

  uploadImage($event: any) {

  }

}
