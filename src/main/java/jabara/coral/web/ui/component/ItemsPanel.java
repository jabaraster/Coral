/**
 * 
 */
package jabara.coral.web.ui.component;

import jabara.coral.entity.EItem;
import jabara.coral.entity.EItemSet;
import jabara.general.ArgUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * @author jabaraster
 */
public class ItemsPanel extends Panel {
    private static final long serialVersionUID = -6723379956276494432L;

    private final EItemSet    itemsValue;

    private ListView<EItem>   items;

    /**
     * @param pId
     * @param pItemSet
     */
    public ItemsPanel(final String pId, final EItemSet pItemSet) {
        super(pId);
        this.itemsValue = ArgUtil.checkNull(pItemSet, "pItemSet"); //$NON-NLS-1$
        this.add(getItems());
    }

    @SuppressWarnings("serial")
    private ListView<EItem> getItems() {
        if (this.items == null) {
            final List<EItem> l = new ArrayList<>(this.itemsValue.getItems());
            l.add(new EItem());
            this.items = new ListView<EItem>("items") { //$NON-NLS-1$
                @Override
                protected void populateItem(final ListItem<EItem> pItem) {
                    final EItem item = pItem.getModelObject();
                    pItem.setModel(new CompoundPropertyModel<>(item));
                    pItem.add(new Label("label")); //$NON-NLS-1$
                }
            };
        }
        return this.items;
    }
}
