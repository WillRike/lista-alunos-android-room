package br.com.alura.agenda.asynktask;

import android.os.AsyncTask;

import br.com.alura.agenda.model.Telefone;

abstract class BaseAlunoComTelefoneTask extends AsyncTask<Void, Void, Void> {
    private final FinalizadaListener listener;

    BaseAlunoComTelefoneTask(FinalizadaListener listener) {
        this.listener = listener;
    }

    void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone :
                telefones) {
            telefone.setAlunoId(alunoId);
        }
    }

    public interface FinalizadaListener{
        void quandoFinalizada();
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        listener.quandoFinalizada();
    }
}
