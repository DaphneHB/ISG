#include "PP_ALGO.h"

/* Move all units to a specific position */
Debut
	/* open the Prog&Play API */
	OUVRIR_JEU;
	/* iterate all units */
	PREMIERE_UNITE;
	TantQue current_unit != DERNIERE_UNITE Faire
		/* order the current unit to move to the target position */
		DEPLACER_VERS(100, 100);
		UNITE_SUIVANTE;
	FinTantQue
	DEPLACER_VERS(100, 100);
	/* close the Prog&Play API */
	FERMER_JEU;
Fin
