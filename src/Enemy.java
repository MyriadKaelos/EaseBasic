public class Enemy {
    public int eX;
    public int eY;
    public int level;
    public Enemy(int x, int y,int level) {
        this.eX = x;
        this.eY = y;
        this.level = level;
    }
    public boolean upDate(int x, int y) {
        if(x > eX) { eX+=(level/5 + 1);} else {eX-=(level/5 + 1);}
        if(y > eY) { eY+=(level/5 + 1);} else {eY-=(level/5 + 1);}
        if(x + 10 > eX && x < eX + 10 && y + 10 > eY && y < eY + 10) {return true;} else {return false;}
    }
}