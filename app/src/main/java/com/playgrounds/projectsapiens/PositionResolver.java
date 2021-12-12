package com.playgrounds.projectsapiens;

import com.playgrounds.projectsapiens.listitems.ListItemKind;

public class PositionResolver {
    private static final int INDEX_RESERVED_FOR_TABOOLA_1 = 2;
    private static final int INDEX_RESERVED_FOR_TABOOLA_2 = 9;

    public int get(int position) {
        if (position == INDEX_RESERVED_FOR_TABOOLA_1) {
            return ListItemKind.TABOOLA_WIDGET.id;
        } else if (position == INDEX_RESERVED_FOR_TABOOLA_2) {
            return ListItemKind.TABOOLA_FEED.id;
        } else {
            return ListItemKind.FEED_ITEM.id;
        }
    }
}
