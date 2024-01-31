import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-create-player',
  templateUrl: './create-player.component.html',
  styleUrls: ['./create-player.component.css']
})
export class CreatePlayerComponent implements OnInit{
  namePlayer!: string;
  positionPlayer!: string;
  agePlayer!: number;
  heightPlayer!: number;
  weightPlayer!: number;
  valuePlayer!: number;
  clausePlayer!: number;
  pointsPlayer!: number;
  teamPlayer!: string;

  constructor(
    private playerService: PlayerService,
    private toast: ToastrService,
    private router: Router
  ){ }

  ngOnInit(): void {
  }

  onCreatePlayer(): void{
    const player = new Player(this.namePlayer, this.positionPlayer, this.agePlayer, this.heightPlayer, this.weightPlayer, this.valuePlayer, this.clausePlayer, this.pointsPlayer, this.teamPlayer);
    this.playerService.create(player).subscribe({
      next: () => {
        this.toast.success('Player created successfully', 'OK', {timeOut:3000, positionClass: 'toast-top-center'});
        this.router.navigate(['']);
      },
      error: (err: HttpErrorResponse) => {
        this.toast.error('Failed to create a player:' + err.error.message, 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
      }
    }
    )
  }

}
