package sample;

public class MovePlayer {

    private int position ;
    private int xPos ;
    private int yPos ;
    private int cir1 ;
    private int[] intArray = new int[4];

    public MovePlayer(int position, int xPos, int yPos, int cir1) {
        this.position = position;
        this.xPos = xPos;
        this.yPos = yPos;
        this.cir1 = cir1;

    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getCir1() {
        return cir1;
    }

    public void setCir1(int cir1) {
        this.cir1 = cir1;
    }

      Main main = new Main();

    public int[]  movePlayer(int playerXPos, int playerYPos, int posCir1, int rand) {



        if (playerXPos == 40 && playerYPos == 40) {
            playerXPos = 40;
            playerYPos = 40;
        }

        for (int i = 0; i < rand; i++) {
            if (posCir1 % 2 == 1) {
                playerXPos += 80;
            }
            if (posCir1 % 2 == 0) {
                playerXPos -= 80;
            }
            if (playerXPos > 760) {
                playerYPos -= 80;
                playerXPos -= 80;
                posCir1++;
            }
            if (playerXPos < 40) {
                playerYPos -= 80;
                playerXPos += 80;
                posCir1++;
            }

            if (playerXPos < 30 || playerYPos < 30) {
                playerXPos = 40;
                playerYPos = 40;

            }
        }

            intArray[0] = playerXPos;
            intArray[1] = playerYPos;
            intArray[2] = posCir1;
            intArray[3] = rand;
        return intArray;
    }

    // New positions of player for Snakes and Ladders
    public int[] moveNewPlayer(int playerPosition, int playerXPos, int playerYPos, int posCir1 ) {


        if (playerPosition == 3) {
            playerXPos = 120;
            playerYPos = 520;
            posCir1 += 3;
            playerPosition = 39;
        }
        if (playerPosition == 10) {
            playerXPos = 680;
            playerYPos = 680;
            posCir1 += 1;
            playerPosition = 12;
        }
        if (playerPosition == 27) {
            playerXPos = 600;
            playerYPos = 360;
            posCir1 += 3;
            playerPosition = 53;
        }
        if (playerPosition == 56) {
            playerXPos = 280;
            playerYPos = 120;
            posCir1 += 3;
            playerPosition = 84;
        }
        if (playerPosition == 61) {
            playerXPos = 120;
            playerYPos = 40;
            posCir1 += 3;
            playerPosition = 99;
        }
        if (playerPosition == 72) {
            playerXPos = 760;
            playerYPos = 120;
            posCir1 += 1;
            playerPosition = 90;
        }
        if (playerPosition == 16) {
            playerXPos = 600;
            playerYPos = 680;
            playerPosition = 13;
        }
        if (playerPosition == 31) {
            playerXPos = 280;
            playerYPos = 760;
            posCir1 -= 3;
            playerPosition = 4;
        }
        if (playerPosition == 47) {
            playerXPos = 360;
            playerYPos = 600;
            posCir1 -= 2;
            playerPosition = 25;
        }
        if (playerPosition == 63) {
            playerXPos = 40;
            playerYPos = 360;
            posCir1 -= 1;
            playerPosition = 60;
        }
        if (playerPosition == 66) {
            playerXPos = 680;
            playerYPos = 360;
            posCir1 -= 1;
            playerPosition = 52;
        }
        if (playerPosition == 97) {
            playerXPos = 440;
            playerYPos = 200;
            posCir1 -= 2;
            playerPosition = 75;
        }
        if (playerPosition >= 100) {
            playerXPos = 40;
            playerYPos = 40;
            posCir1 = 10;
            playerPosition = 100;
        }
        intArray[0] = playerXPos;
        intArray[1] = playerYPos;
        intArray[2] = posCir1;
        intArray[3] = playerPosition;

        return intArray;
    }

}