/** Copyright to N.Kolaba
All rights reserved ©.
**/

<<<<<<< HEAD:src/main/java/al/tonikolaba/gamestate/OptionsState.java
package al.tonikolaba.gamestate;
=======
package al.artofsoul.batbatgame.gamestate;
>>>>>>> aae2fa52323674b457b6667781f55e1db62713db:src/main/java/al/artofsoul/batbatgame/gamestate/OptionsState.java

import java.awt.Graphics2D;

import al.tonikolaba.audio.JukeBox;
import al.tonikolaba.handlers.Keys;

/**
 * @author N.Kolaba
 */

public class OptionsState extends BasicState {

	public OptionsState(GameStateManager gsm) {
		super(gsm);
		options = new String[] { "HowTo Play", "Language", "Back" };
	}

	@Override
	public void update() {
		// check keys
		handleInput();
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		g.drawRect(75, 90, 155, 100); // Fills a square
		g.drawString("HowTo Play", 140, 133);
		g.drawString("Language", 140, 148);
		g.drawString("Back", 140, 163);
	}

	@Override
	protected void select() {
		switch (currentChoice) {
		case 0:
			JukeBox.play("menuselect");
			gsm.setState(GameStateManager.HOWTOPLAY);
			break;
		case 1:
			JukeBox.play("menuselect");
			gsm.setState(GameStateManager.OPTIONSSTATE);
			break;
		case 2:
			JukeBox.play("menuselect");
			gsm.setState(GameStateManager.MENUSTATE);
			break;
		default:
			gsm.setState(GameStateManager.MENUSTATE);
			break;
		}
	}

	@Override
	public void handleInput() {
		if (Keys.isPressed(Keys.ENTER))
			select();
		if (Keys.isPressed(Keys.UP) && currentChoice > 0) {
			JukeBox.play("menuoption", 0);
			currentChoice--;
		}
		if (Keys.isPressed(Keys.DOWN) && currentChoice < options.length - 1) {
			JukeBox.play("menuoption", 0);
			currentChoice++;
		}
	}
}