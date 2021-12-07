package ir.maktab.btrs.btrsa.service;

import ir.maktab.btrs.btrsa.base.service.BaseService;
import ir.maktab.btrs.btrsa.domain.Ticket;
import ir.maktab.btrs.btrsa.domain.dto.TicketDto;

import java.util.List;

public interface TicketService extends BaseService<Ticket, Long> {

    List<Ticket> searchByFromAndTo(TicketDto ticketDto);

    List<Ticket> sortByAirLineName(String name);

    List<Ticket> sortedByPrice(int choose);

}
