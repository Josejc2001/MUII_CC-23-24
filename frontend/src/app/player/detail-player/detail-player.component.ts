import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-detail-player',
  templateUrl: './detail-player.component.html',
  styleUrls: ['./detail-player.component.css']
})
export class DetailPlayerComponent implements OnInit{
  player!: Player;

  constructor(
    private playerService: PlayerService,
    private router: Router,
    private toast: ToastrService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getPlayer();
  }

  getPlayer(): void{
    const id : string = this.activatedRoute.snapshot.params['id'];
    this.playerService.detail(id).subscribe({
      next: (p : Player) => this.player = p,
      error: (err: Error) => {
        this.toast.error('No player found with that id', 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
        this.router.navigate(['']);
      }
    }
    );
  }

}
