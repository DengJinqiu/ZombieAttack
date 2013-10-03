package com.jinqiu.zombieattack.listener;

/** Listener to the zombie */
public interface ZombieListener {

	/** Change the adding new zombie frequency */
	void changeAddNewZombieFre(int newFrenewFrequency);

	/** Turn the adding new zombie frequency to the original frequency */
	void changeBackAddNewZombieFre();

	/**
	 * Change the score
	 * 
	 * @param change
	 *            The changing of the score.
	 */
	public void changeScore(int change);

}
