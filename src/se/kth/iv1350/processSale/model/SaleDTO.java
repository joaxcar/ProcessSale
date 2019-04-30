package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.List;

public interface SaleDTO {

    /**
     * Returns last added item from <code>Sale</code>
     *
     * @return <code>ItemDTO</code> of last added item
     */
    ItemDTO getLastAddedItem();

    /**
     * Returns current total price of items in the <code>Sale</code>
     *
     * @return <code>Amount</code> containing total price
     */
    Amount getRunningTotal();

    /**
     * Returns total VAT of items in the <code>Sale</code>
     *
     * @return <code>Amount</code> containing total VAT
     */
    Amount getVAT();

    /**
     * Returns current price including VAT of items in <code>Sale</code>
     *
     * @return <code>Amount</code> containing total price including VAT
     */
    Amount getRunningTotalIncVAT();

    /**
     * Returns number of items in <code>Sale</code>
     *
     * @return number of items as an integer
     */
    int getItemCount();

    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>ItemDTO</code>
     */
    List<ItemDTO> getItemList();
}
