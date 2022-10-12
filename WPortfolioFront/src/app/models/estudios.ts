export class Estudios {
    id?: number;
    estCarrera: string;
    estMencion: string;
    estEstado: string;
    estInstituto: string;
    estLugar: string;

    constructor(
        estCarrera: string, 
        estMencion: string, 
        estEstado: string,
        estInstituto: string,
        estLugar: string
    ) {
        this.estCarrera = estCarrera;
        this.estMencion = estMencion;
        this.estEstado = estEstado;
        this.estInstituto = estInstituto;
        this.estLugar = estLugar;
    }
}
