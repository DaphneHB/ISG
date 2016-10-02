#include "PP_IMM.h"

/* Move all units to a specific position */
int main (){
	int i;
	/* define target position */
	PP_Pos pos;
	pos.x = 100.0;
	pos.y = 100.0;
	
	PP_Pion myBytes [NB_MAX_PIONS];
	int myBytesSize;
	PP_Pion enemyBytes [NB_MAX_PIONS];
	int enemyBytesSize;
	
	/* open the Prog&Play API */
	PP_Initialisation();
	/* refresh data */
	PP_ObtenirPions(myBytes, &myBytesSize, enemyBytes, &enemyBytesSize);
	/* iterate all units */
	for (i = 0 ; i < myBytesSize ; i++){
		/* order the current unit to move to the target position */
		PP_Deplacer(myBytes[i], pos);
	}
	/* close the Prog&Play API */
	PP_Fin();
	return 0;
}
