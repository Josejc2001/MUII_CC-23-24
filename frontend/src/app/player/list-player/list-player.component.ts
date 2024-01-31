import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';
import { TokenService } from 'src/app/services/token.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-player',
  templateUrl: './list-player.component.html',
  styleUrls: ['./list-player.component.css']
})
export class ListPlayerComponent implements OnInit{
  players: Player[] = [];
  role!: string;
  isAdmin: boolean = false;
  userCart!: string;

  constructor(
    private playerService : PlayerService,
    private toast: ToastrService,
    private tokenService: TokenService
  ) { }

  ngOnInit(): void{
    if(this.tokenService.getToken() != null){
      this.getPlayers();
    }

    this.role = this.tokenService.getRole();
    if(this.role == "ADMIN"){
      this.isAdmin = true;
    } 
  }

  getPlayers(): void{
    this.playerService.list().subscribe({
      next: (data: Object) => {
        console.log(data);
        this.players = Object.values(data).at(0);
      },
      error: (err:Error) => {
        this.toast.error('Error with players', 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
      }
    }
    );
  }

  onDelete(id: string): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You cannot undo',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'OK',
      cancelButtonText: 'Cancel'
    }).then((result) => {
      if(result.value){
        this.playerService.delete(id).subscribe({
          next: () => {
            this.toast.success('Player deleted successfully', 'OK', {timeOut:3000, positionClass: 'toast-top-center'});
            this.getPlayers();
          },
          error: () => {
            this.toast.error('Failed to delete a player', 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
          }
        })
      } else if(result.dismiss === Swal.DismissReason.cancel){
        Swal.fire(
          'canceled',
          'player not deleted',
          'error'
        )
      }
    })
  }
}
