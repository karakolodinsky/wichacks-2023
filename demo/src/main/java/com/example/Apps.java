package com.example;

import javafx.scene.image.Image;

public class Apps {
        private Image body;
        private Image top;
        private Image bottom;
        private Image hair;
        private Image shoes;
        private Image cult;


        public Apps ( Image body, Image top, Image bottom, Image hair,  Image shoes, Image cult){
                this.body = body;
          this.top = top;
          this.bottom = bottom;
           this.hair = hair;
            this.shoes = shoes;
            this.cult = cult;
                
        }
        
        public  Image getBody() {
                return this.body;
        }
        
        public  Image getTop() {
                return this.top;
        }
        public  Image getHair() {
                return this.hair;
        }
        public  Image getShoes() {
                return this.shoes;
        }
        public  Image getCult() {
                return this.cult;
        }
        public  Image getBottom() {
                return this.bottom;
        }
        
        public void setBody(Image body) {
                this.body = body;
        }
        
        public void setCult(Image cult) {
                this.cult = cult;
        }
        
        public void setHair(Image hair) {
                this.hair = hair;
        }
        
        public void setBottom(Image bottom) {
                this.bottom = bottom;
        }
        
        public void setShoes(Image shoes) {
                this.shoes = shoes;
        }
        
        
        public void setTop(Image top) {
                this.top = top;
        }
}
