/* * * ./app/comments/components/comment-form.component.ts * * */
// Imports
import { Component, EventEmitter, Input, OnChanges } from '@angular/core';
import { NgForm }    from '@angular/forms';
import {Observable} from 'rxjs/Rx';
import { CompileService } from '../services/compile.service';
import {Compile} from '../model/compile';

// Component decorator
@Component({
    selector: 'comment-form',
    template: `
        <form (ngSubmit)="compileCode()">
            <div class="form-group">
               <!-- <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" class="form-control" placeholder="Author" [(ngModel)]="model.author" name="author">
                </div>
                <br /> -->
                <textarea class="form-control" rows="10" placeholder="Text" [(ngModel)]="code" name="text"></textarea>
                <br />
                <button type="submit" class="btn btn-primary btn-block">Compile</button>
                <!--<button *ngIf="editing" type="submit" class="btn btn-warning btn-block">Update</button>-->
            </div>
        </form>

        <div *ngIf="compileResult" class="form-group">      
              Compilation Result : {{compileResult.compilationResult}}
              <br/>
              {{compileResult.errors}}
        </div>

    `,
    providers: [CompileService]
})
// Component class
export class CompileFormComponent{ 
    // Constructor with injected service
    constructor(
        private compileService: CompileService
        ){}
    
    private code = "";
    compileResult : Compile;
    
     compileCode():void{
         //alert(this.code);
         this.compileService.postCode(this.code).then(result => this.compileResult = result);
     }
 }
