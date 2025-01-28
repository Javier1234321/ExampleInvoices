package org.javi.appinvoices.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    private int folio;
    private String description;
    private Date date;
    private Costumer costumer;
    private ItemInvoice[] items;
    private int indiceItems;
    public static  final int MAX_ITEMS=10;
    private static  int ultimoFolio;
    public Invoice(String description, Costumer costumer) {
        this.description = description;
        this.costumer = costumer;
        this.items=new ItemInvoice[MAX_ITEMS];
        this.folio=++ultimoFolio;
        this.date=new Date();
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public ItemInvoice[] getItems() {
        return items;
    }
    public  void addItemInvoice(ItemInvoice item)
    {
        if (indiceItems<MAX_ITEMS)
        {
            this.items[indiceItems++]=item;
        }
    }
    public float calcularTotal()
    {
        float total=0.0f;
        for (ItemInvoice item: this.items)
        {
            if((item==null))
            {
                continue;
            }
            total+=item.calcularImporte();
        }
        return total;
    }
    public String generarDetalle()
    {
        StringBuilder sb=new StringBuilder("Factura N°: ");
        sb.append(folio);
        sb.append("\nCostumer: ").append(this.costumer.getNombre())
                .append("\tNIF: ").append(this.costumer.getNif())
                .append("\nDescripcion").append(getDescription())
                .append("\n#\tNombre\t$\tCant.\tTotal\n");
        SimpleDateFormat df=new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ").append(df.format(this.date)).append("\n");
        for (ItemInvoice item: this.items)
        {
            if (item==null)
            {
                continue;
            }
            sb.append(item.getProduct().getCodigo()).append("\t")
                    .append(item.getProduct().getNombre()).append("\t")
                    .append(item.getProduct().getPrecio()).append("\t")
                    .append(item.getProduct().getPrecio()).append("\t")
                    .append(item.getCantidad()).append("\t")
                    .append(item.calcularImporte()).append("\n");
        }
        sb.append("\nGran total: ").append(calcularTotal());
        return sb.toString();

    }
}
