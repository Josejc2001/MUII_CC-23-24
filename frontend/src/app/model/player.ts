export class Player {
    id!: string;
    name: string;
    position: string;
    age: number;
    height: number;
    weight: number;
    value: number;
    clause: number;
    points: number;
    team: string;

    constructor(name:string, position:string, age:number, height: number, weight: number, value: number, clause: number, points: number, team: string ){
        this.name = name;
        this.position = position;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.value = value;
        this.clause = clause;
        this.points = points;
        this.team = team;
    }
}
