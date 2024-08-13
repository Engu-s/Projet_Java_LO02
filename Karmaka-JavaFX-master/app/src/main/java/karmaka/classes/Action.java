package karmaka.classes;

/**
 * L'énumération Action représente les différentes actions possibles qu'un
 * joueur peut entreprendre durant son tour dans une partie de Karmaka.
 * Les actions incluent :
 * <ul>
 * <li>PIOCHER_DECK : Action permettant au joueur de piocher une carte depuis
 * son deck.</li>
 * <li>CHOISIR_CARTE_MAIN : Action permettant au joueur de choisir une carte de
 * sa main.</li>
 * <li>PASSER : Action permettant au joueur de passer son tour.</li>
 * </ul>
 */
public enum Action {
    PIOCHER_DECK, CHOISIR_CARTE_MAIN, PASSER, TOUR_SUIVANT_ROBOT
}
