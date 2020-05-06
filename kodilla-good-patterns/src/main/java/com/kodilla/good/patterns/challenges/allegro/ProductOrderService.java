import com.kodilla.good.patterns.challenges.allegro.InformationService;
import com.kodilla.good.patterns.challenges.allegro.PurchaseRepository;
import com.kodilla.good.patterns.challenges.allegro.PurchaseService;

public class ProductOrderService {

    private InformationService informationService;
    private PurchaseService purchaseService;
    private PurchaseRepository purchaseRepository;

    public ProductOrderService(final InformationService informationService,
                               final PurchaseService purchaseService,
                               final PurchaseRepository purchaseRepository) {
        this.informationService = informationService;
        this.purchaseService = purchaseService;
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseDto process(final PurchaseRequest purchaseRequest) {
        boolean isPurchased = purchaseService.purchase(purchaseRequest.getUser(), purchaseRequest.getQuantity(),
                purchaseRequest.getProduct());

        if(isPurchased) {
            informationService.inform(purchaseRequest.getUser());
            purchaseRepository.createDataToRepository(purchaseRequest.getUser(), purchaseRequest.getQuantity(), purchaseRequest.getProduct());
            return new PurchaseDto(purchaseRequest.getUser(), true);
        } else {
            return new PurchaseDto(purchaseRequest.getUser(), false);
        }
    }
}