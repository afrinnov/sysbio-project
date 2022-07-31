/**
 *
 */
package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;

/**
 * @author ngos
 */
public enum FormatType {
    FIFTH(223), QUARTER(279), TWO_FIFTH(447),
    TREE_FIFTH(670), TREE_QUARTER(838),
    FOUR_FIFTH(894), NONE(0), LIGNE_TABLEAU(-1),
    SIXTH(110, true), THIRD(220, true), HALF(330, true),
    TWO_THIRD(440, true), FIVE_SIXTH(550, true),
    FULL(700, true);

    private final int height;
    @Getter
    private final boolean used;

    FormatType(int height, boolean used) {
        this.height = height;
        this.used = used;
    }

    FormatType(int height) {
        this(height, false);
    }

    public int getHeight() {
        return height;
    }

}
