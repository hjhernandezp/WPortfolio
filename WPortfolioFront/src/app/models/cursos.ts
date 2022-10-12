export class Cursos {
    id?: number;
    curNombre: string;
    curInstituto: string;
    curLugar: string;
    curHoras: number;

    constructor(
        curNombre: string, 
        curInstituto: string,
        curLugar: string, 
        curHoras: number
    ) {
        this.curNombre = curNombre;
        this.curInstituto = curInstituto;
        this.curLugar = curLugar;
        this.curHoras = curHoras;
    }
}
