/* * * ./app/comments/components/index.ts * * */
// Imports
import { Component} from '@angular/core';

@Component({
    selector: 'compile-widget',
    template: `
        <div>
            <comment-form></comment-form>
            <!--<comment-list [listId]="listId" [editId]="editId"></comment-list>-->
        </div>
    `,
})
export class CommentComponent { 
    // Event tracking properties
   /* private listId = 'COMMENT_COMPONENT_LIST';
    private editId = 'COMMENT_COMPONENT_EDIT';*/
 }
