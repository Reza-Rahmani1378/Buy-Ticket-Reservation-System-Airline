package ir.maktab.btrs.btrsa.service.impl;


import ir.maktab.btrs.btrsa.base.service.impl.BaseServiceImpl;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.dto.TicketDto;
import ir.maktab.btrs.btrsa.repository.TicketRepository;
import ir.maktab.btrs.btrsa.service.TicketService;

import java.util.List;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository>
        implements TicketService {


    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> searchByFromAndTo(TicketDto ticketDto) {
        return repository.searchByFromAndTo(ticketDto);
    }

    @Override
    public List<Ticket> sortByAirLineName(String name) {
        return repository.sortByAirLineName(name);
    }

    @Override
    public List<Ticket> sortedByPrice(int choose) {
        return repository.sortedByPrice(choose);
    }
}
