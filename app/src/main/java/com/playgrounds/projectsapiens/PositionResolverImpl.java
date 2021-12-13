package com.playgrounds.projectsapiens;

import com.playgrounds.projectsapiens.listitems.ListItemKind;

public class PositionResolverImpl implements PositionResolver {
    public static final int OVERALL_POSITIONS = 10;
    static final int INDEX_RESERVED_FOR_TABOOLA_1 = 2;
    static final int INDEX_RESERVED_FOR_TABOOLA_2 = 9;

    @Override
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
